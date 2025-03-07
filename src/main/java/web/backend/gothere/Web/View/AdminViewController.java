package web.backend.gothere.Web.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import web.backend.gothere.Repositories.Entities.UserRole;
import web.backend.gothere.Services.BarImgsService;
import web.backend.gothere.Services.BarService;
import web.backend.gothere.Services.TableService;
import web.backend.gothere.Services.OffersService;
import web.backend.gothere.Services.ReservationBookService;
import web.backend.gothere.Services.SchedulesService;
import web.backend.gothere.Services.UserService;
import web.backend.gothere.Services.Models.TableDTO;
import web.backend.gothere.Services.Models.BarDTO;
import web.backend.gothere.Services.Models.OfferDTO;
import web.backend.gothere.Services.Models.ReservationBookDTO;
import web.backend.gothere.Services.Models.ScheduleDTO;
import web.backend.gothere.Services.Models.UserDTO;

@Controller
@RequestMapping("admin")
public class AdminViewController {
    
    private final UserService userService;
    private final BarService barService;
    private final OffersService offerService;
    private final ReservationBookService reservationBookService;
    private final TableService tableService;
    private final BarImgsService barImgsService;
    private final SchedulesService schedulesService;
    

    public AdminViewController(UserService userService, BarService barService, OffersService offerService, ReservationBookService reservationBookService, TableService tableService,  BarImgsService barImgsService, SchedulesService schedulesService) {
        this.userService = userService;
        this.barService = barService;
        this.offerService = offerService;
        this.reservationBookService = reservationBookService;
        this.tableService = tableService;
        this.barImgsService = barImgsService;
        this.schedulesService = schedulesService;
    }

    @GetMapping("")
    public ModelAndView barLoginPage(@CookieValue( required = false, value="adminlogin") String cookie ){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin/home");
        
        if(cookie != null && isBarOwner(cookie)){
            return mv2;
        }
      
        ModelAndView mv = new ModelAndView("admin/login");
        return mv;
    } 

    @GetMapping("/home")
    public ModelAndView barHomePage(@CookieValue( required = false, value="adminlogin") String cookie ){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
        ModelAndView mv = new ModelAndView("admin/admin_home");
       
       UserDTO user = userService.getUserByToken(cookie);
       
    
        mv.addObject("bar", barService.getBarById(user.getIdBar()));

        return mv;
    }

    @GetMapping("/offers")
    public ModelAndView barOffersPage(@CookieValue( required = false, value="adminlogin") String cookie ){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
        UserDTO user = userService.getUserByToken(cookie);
        
        ModelAndView mv = new ModelAndView("admin/offers");
        List<OfferDTO> offers = offerService.findOffersByBarId(user.getIdBar());
        mv.addObject("offers",offers);

        return mv;
    }

    @GetMapping("/reservations")
    public ModelAndView barReservationsPage(@CookieValue( required = false, value="adminlogin") String cookie, 
        @RequestParam (required = false, value= "phone") String phone,
        @RequestParam( required = false, value="date")@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
        
        ModelAndView mv = new ModelAndView("admin/reservations");
       
       UserDTO user = userService.getUserByToken(cookie);
       
        List<ReservationBookDTO> reservations = reservationBookService.getAllByBar(user.getIdBar(), phone, date);
        mv.addObject("reservations",reservations);

        return mv;
    }

    @GetMapping("/tables")
    public ModelAndView tablesPage(@CookieValue( required = false, value="adminlogin") String cookie ){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
    
        ModelAndView mv = new ModelAndView("admin/tables");
       
       UserDTO user = userService.getUserByToken(cookie);
       
        List<TableDTO> tables = tableService.getByBarId(user.getIdBar());
        Collections.sort(tables);
        mv.addObject("tables",tables);

        return mv;
    }
    @GetMapping("/tables/edit/{idTable}")
    public ModelAndView tablesEdit(@CookieValue( required = false, value="adminlogin") String cookie,
     @PathVariable Long idTable ){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
    
        ModelAndView mv = new ModelAndView("admin/tables_edit");
       
        TableDTO table = tableService.getById(idTable);
        List<ScheduleDTO> scheduleList = schedulesService.getAll();
        mv.addObject("scheduleList",scheduleList);
        mv.addObject("table",table);

        return mv;
    }

    private boolean isBarOwner(String cookie){
        try{
            UserDTO user = userService.getUserByToken(cookie);
            boolean isBarOwner = user.getUserRole().equals(UserRole.BAR.toString());
            return isBarOwner;
        }catch(Exception ex){
            return false;
        }
        
    }

    @GetMapping("/offers/new")
    public ModelAndView newOfferPage(@CookieValue( required = false, value="adminlogin") String cookie ){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
        UserDTO user = userService.getUserByToken(cookie);
        BarDTO bar = barService.getBarById(user.getIdBar());
        ModelAndView mv = new ModelAndView("admin/add_offer");
        mv.addObject("bar", bar);
        return mv;
    }
    @GetMapping("/offer/{idOffer}/edit")
    public ModelAndView editOfferPage(@CookieValue( required = false, value="adminlogin") String cookie, @PathVariable("idOffer") Long idOffer){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
        OfferDTO offer = offerService.findbyOfferId(idOffer);
        ModelAndView mv = new ModelAndView("admin/edit_offer");
        mv.addObject("offer", offer);

        return mv;
    }
    @GetMapping("/tables/new")
    public ModelAndView newTablePage(@CookieValue( required = false, value="adminlogin") String cookie ){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
        UserDTO user = userService.getUserByToken(cookie);
        
        ModelAndView mv = new ModelAndView("admin/add_table");
        List<ScheduleDTO> scheduleList = schedulesService.getAll();
        mv.addObject("barId",user.getIdBar());
        mv.addObject("scheduleList",scheduleList);

        return mv;
    }
    @GetMapping("/reservations/new")
    public ModelAndView newReservationPage(@CookieValue( required = false, value="adminlogin") String cookie ){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
        UserDTO user = userService.getUserByToken(cookie);
        
        ModelAndView mv = new ModelAndView("admin/add_reservations");
        mv.addObject("user",user);

        return mv;
    }

    @PostMapping("/image/save")
    public ModelAndView saveImage(@CookieValue( required = false, value="adminlogin") String cookie, 
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
         
        if(cookie == null){
            return new ModelAndView("redirect:/admin");
        }
        if(!isBarOwner(cookie)){
            return new ModelAndView("redirect:/admin");
        }
        Long idBar = userService.getUserByToken(cookie).getIdBar();
        barImgsService.add(idBar, multipartFile);
        
        return new ModelAndView("redirect:/admin/home");
    }

    @DeleteMapping("/image/delete/{idImgBar}")
    public ModelAndView deleteImage(@CookieValue( required = false, value="adminlogin") String cookie, @PathVariable("idImgBar") Long idImgBar) throws IOException {
         
        if(cookie == null){
            return new ModelAndView("redirect:/admin");
        }
        if(!isBarOwner(cookie)){
            return new ModelAndView("redirect:/admin");
        }
       
       barImgsService.deleteById(idImgBar);

        return new ModelAndView("redirect:/admin/home");
    }
    
    
    //paso dos creación oferta
    @GetMapping("/offer/{idOffer}/add/image")
    public ModelAndView editNewOfferImage(@CookieValue( required = false, value="adminlogin") String cookie, @PathVariable("idOffer") Long idOffer){
        
        ModelAndView mv2 = new ModelAndView("redirect:/admin");
        if(cookie == null){
            return mv2;
        }
        if(!isBarOwner(cookie)){
            return mv2;
        }
        OfferDTO offer = offerService.findbyOfferId(idOffer);
        ModelAndView mv = new ModelAndView("admin/add_offer_image");
        mv.addObject("offer", offer);

        return mv;
    }

    @PostMapping("/image/offer/save/{idOffer}")
    public ModelAndView saveOfferImage(@CookieValue( required = false, value="adminlogin") String cookie, 
            @RequestParam("image") MultipartFile multipartFile, @PathVariable("idOffer") Long idOffer) throws IOException {
         
        if(cookie == null){
            return new ModelAndView("redirect:/admin");
        }
        if(!isBarOwner(cookie)){
            return new ModelAndView("redirect:/admin");
        }
        OfferDTO offerToSaveImg = offerService.findbyOfferId(idOffer);
        offerService.addOfferImage(offerToSaveImg, multipartFile);
        
        return new ModelAndView("redirect:/admin/offers");
    }

    @DeleteMapping("/image/offer/{idOffer}/delete")
    public ModelAndView deleteOfferImage(@CookieValue( required = false, value="adminlogin") String cookie, @PathVariable("idOffer") Long idOffer) throws IOException {
         
        if(cookie == null){
            return new ModelAndView("redirect:/admin");
        }
        if(!isBarOwner(cookie)){
            return new ModelAndView("redirect:/admin");
        }
        OfferDTO offer = offerService.findbyOfferId(idOffer);
        offerService.deleteOfferImage(offer);
        
        return new ModelAndView("redirect:/admin/offer/"+idOffer+"/edit");
    }

}
