// package web.backend.gothere.Web.Config;

// import java.time.LocalDate;
// import java.time.LocalTime;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// import web.backend.gothere.Repositories.Entities.BarEntity;
// import web.backend.gothere.Repositories.Entities.BarImgsEntity;
// import web.backend.gothere.Repositories.Entities.TableEntity;
// import web.backend.gothere.Repositories.Entities.ConfirmationTokenEntity;
// import web.backend.gothere.Repositories.Entities.OfferEntity;
// import web.backend.gothere.Repositories.Entities.ReservationBookEntity;
// import web.backend.gothere.Repositories.Entities.ScheduleEntity;
// import web.backend.gothere.Repositories.Entities.ScheduleTableReservationEntity;
// import web.backend.gothere.Repositories.Entities.TableEntity;
// import web.backend.gothere.Repositories.Entities.UserEntity;
// import web.backend.gothere.Repositories.Entities.UserOfferEntity;
// import web.backend.gothere.Repositories.Entities.UserRole;
// import web.backend.gothere.Repositories.Interfaces.BarImgsRepository;
// import web.backend.gothere.Repositories.Interfaces.BarRepository;
// import web.backend.gothere.Repositories.Interfaces.TableRepository;
// import web.backend.gothere.Repositories.Interfaces.ConfirmationTokenRepository;
// import web.backend.gothere.Repositories.Interfaces.OffersRepository;
// import web.backend.gothere.Repositories.Interfaces.ReservationBookRepository;
// import web.backend.gothere.Repositories.Interfaces.ScheduleRepository;
// import web.backend.gothere.Repositories.Interfaces.ScheduleTableReservationRepository;
// import web.backend.gothere.Repositories.Interfaces.UserOfferRepository;
// import web.backend.gothere.Repositories.Interfaces.UserRepository;

// @Configuration
// public class InitDB {
//     @Bean
//     CommandLineRunner initDataBase(OffersRepository offerR, 
//         UserOfferRepository userofferR, 
//         UserRepository userR, 
//         BarRepository barR, 
//         TableRepository barTableR,
//         ReservationBookRepository reservationBookR,
//         ScheduleTableReservationRepository scheduleTableReservationR,
//         ScheduleRepository scheduleR,
//         ConfirmationTokenRepository confirmationTokenR,
//         BarImgsRepository barImgsR
//         ){
            
//         return args -> {
//             //hoarios
//             scheduleR.save(new ScheduleEntity(LocalTime.of(16,00,00),LocalTime.of(17,30,00), null));
//             scheduleR.save(new ScheduleEntity(LocalTime.of(17,30,00),LocalTime.of(19,00,00), null));
//             scheduleR.save(new ScheduleEntity(LocalTime.of(19,00,00),LocalTime.of(20,30,00), null));
//             scheduleR.save(new ScheduleEntity(LocalTime.of(20,30,00),LocalTime.of(22,00,00), null));
//             scheduleR.save(new ScheduleEntity(LocalTime.of(20,00,00),LocalTime.of(22,00,00), null));
//             scheduleR.save(new ScheduleEntity(LocalTime.of(22,00,00),LocalTime.of(23,30,00), null));
            
//             //List<ScheduleEntity> horarios = Arrays.asList(scheduleR.findById(1L).get(),scheduleR.findById(2L).get(),scheduleR.findById(4L).get());
         
//             //bares
//             barR.save(new BarEntity("Bar Venado", "Las mejores tapas a buen precio y el mejor servicio", "618-94-8070", "Calle del Conde de Aranda, 92, 50003 Zaragoza", 41.649651, -0.887482, "schedule", 25, 90, 80, null));
//             barR.save(new BarEntity("Ártico", "Las mejores tapas a buen precio y el mejor servicio", "643-76-9639", "Calle San Blas, 94", 41.65463054785235, -0.8769452428088323, "schedule", 25, 90, 80, null));
//             barR.save(new BarEntity("El Viajero", "Las mejores tapas a buen precio y el mejor servicio", "659-44-2317", "Calle la Salina, 3, 50003 Zaragoza", 41.65546519593979, -0.8874342960022673, "schedule", 25, 90, 80, null));
//             barR.save(new BarEntity("La Sureña", "Las mejores tapas a buen precio y el mejor servicio", "656-38-9819", "Calle Sta. Isabel, 7", 41.65728155577524, -0.8925120896989844, "schedule", 25, 90, 80, null));
//             barR.save(new BarEntity("Veraz ", "Las mejores tapas a buen precio y el mejor servicio", "317-32-4200", "Calle Sta. Isabel, 7", 41.65323258381404, -0.8852162981728614, "schedule", 25, 90, 80, null));
//             barR.save(new BarEntity("Baobab", "Las mejores tapas a buen precio y el mejor servicio", "546-56-0137", "Calle Sta. Isabel, 7", 41.65732467279446, -0.885855207273458, "schedule", 25, 90, 80, null));
//             barR.save(new BarEntity("Malabar", "Las mejores tapas a buen precio y el mejor servicio", "656-38-9819", "Calle Sta. Isabel, 7", 41.65632401991278, -0.8771833249397168, "schedule", 25, 90, 80, null));
//             barR.save(new BarEntity("bar de touluse", "Las mejores tapas a buen precio y el mejor servicio", "66666666", "direccion", 43.80017130521276, 1.5384482791887533, "schedule", 25, 90, 80, null));
//             barR.save(new BarEntity("bar de madrid", "Las mejores tapas a buen precio y el mejor servicio", "66666666", "direccion", 40.41961249648086, -3.696045934742639, "schedule", 25, 90, 80, null));
        
               
//              //mesas
//             barTableR.save(new TableEntity(4,false,barR.findById(1L).get(),null, "1"));
//             barTableR.save(new TableEntity(5,false,barR.findById(1L).get(),null, "2"));
//             barTableR.save(new TableEntity(8,false,barR.findById(1L).get(),null, "3"));
//             barTableR.save(new TableEntity(3,false,barR.findById(2L).get(),null, "4"));
//             barTableR.save(new TableEntity(2,false,barR.findById(2L).get(),null, "5"));
//             barTableR.save(new TableEntity(1,false,barR.findById(2L).get(),null, "6"));
//             barTableR.save(new TableEntity(4,false,barR.findById(2L).get(),null, "7"));
//             barTableR.save(new TableEntity(4,false,barR.findById(2L).get(),null, "8"));
//             barTableR.save(new TableEntity(4,false,barR.findById(3L).get(),null, "1"));
//             barTableR.save(new TableEntity(4,false,barR.findById(4L).get(),null, "2"));
//             barTableR.save(new TableEntity(4,false,barR.findById(5L).get(),null, "1"));
//             barTableR.save(new TableEntity(4,false,barR.findById(6L).get(),null, "1"));
//             barTableR.save(new TableEntity(4,false,barR.findById(7L).get(),null, "1"));
//             barTableR.save(new TableEntity(4,false,barR.findById(8L).get(),null, "1"));
//             barTableR.save(new TableEntity(4,false,barR.findById(7L).get(),null, "1"));

//             //horarios mesas
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(1L).get(), scheduleR.findById(1L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(2L).get(), scheduleR.findById(2L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(3L).get(), scheduleR.findById(3L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(3L).get(), scheduleR.findById(4L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(3L).get(), scheduleR.findById(3L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(4L).get(), scheduleR.findById(1L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(4L).get(), scheduleR.findById(2L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(1L).get(), scheduleR.findById(4L).get()));

//            //ofertas
//            offerR.save(new OfferEntity("Do jarras por 2€", "dos jarricas", "/images/offers/jarras.png", 2.3, 23, 23,  LocalDate.now(), LocalDate.now(), barR.findById(1L).get() ));
//            offerR.save(new OfferEntity("copa gratis", "compa gratis si vienes con amigos", "/images/offers/cuba-libre-banner.png", 2.3, 23, 23, LocalDate.now(), LocalDate.now(),  barR.findById(2L).get() ));
//            offerR.save(new OfferEntity("tapa gratis ", "tapa gratis por usar gothere", "/images/offers/albondigas.jpg", 22.50, 15, 0, LocalDate.of(2021,05,30), LocalDate.of(2022, 01, 01), barR.findById(1L).get() ));

//            //usuarios
//            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//             final String encryptedPassword = bCryptPasswordEncoder.encode("1234");
           
//            UserEntity user1 = userR.save(new UserEntity("freddyma@gmail.com", "Freddy", "Martínez", encryptedPassword,"12345667"));
//            confirmationTokenR.save(new ConfirmationTokenEntity(user1));
//            UserEntity user2 =  userR.save(new UserEntity("hola@gmail.com", "ruben", "valero", encryptedPassword,"234123412"));
//             confirmationTokenR.save(new ConfirmationTokenEntity(user2));
            
//             // //reservas
//             reservationBookR.save(new ReservationBookEntity( userR.findById(1L).get(),LocalDate.now(), false, scheduleTableReservationR.findById(1L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(2L).get(),LocalDate.now(), false, scheduleTableReservationR.findById(3L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(2L).get(),LocalDate.now(), true, scheduleTableReservationR.findById(4L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(2L).get(),LocalDate.now(), true, scheduleTableReservationR.findById(5L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(2L).get(),LocalDate.of(2021,05,1), false, scheduleTableReservationR.findById(6L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(1L).get(),LocalDate.of(2023,8,21), true, scheduleTableReservationR.findById(7L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(1L).get(),LocalDate.of(2023,8,24), false, scheduleTableReservationR.findById(5L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(1L).get(),LocalDate.of(2021,05,23), false, scheduleTableReservationR.findById(5L).get()));
           
//             //user-token
//             // BarEntity barTest = barR.findById(2L).get();
//             // UserEntity userTest = userR.findById(3L).get();
//             UserEntity userTest = new UserEntity("vinademartin@hotmail.com", "Felipe", "Sánchez", encryptedPassword , "976453445");
//             userTest.setUserRole(UserRole.BAR);
//             BarEntity barTest = new BarEntity();
//             barTest.setName("La viña de Martín");
//             barTest.setAllowedCapacity(100);
//             barTest.setCurrentCapacity(2);
//             barTest.setDescription("Las mejores tapas a buen precio y el mejor servicio");
//             barTest.setAddress("Calle Lolo n 2,1 Zaragoza");
//             barTest.setLength(-0.8725120896989844);
//             barTest.setLatitude(41.65828155577524);
//             barTest.setPhone("976567890");
//             barTest.setSchedule("De martes a domingo de 8:00-00:00");
//             barTest.setTotalCapacity(150);
//             barTest.setUser(userTest);
//             userTest.setBar(barTest);
//             userR.save(userTest);
//             confirmationTokenR.save(new ConfirmationTokenEntity(userTest));

//             //mesas
//             barTableR.save(new TableEntity(4,false,barR.findById(10L).get(),null, "1"));
//             barTableR.save(new TableEntity(5,false,barR.findById(10L).get(),null, "2"));
//             barTableR.save(new TableEntity(8,false,barR.findById(10L).get(),null,"3"));
//             barTableR.save(new TableEntity(3,false,barR.findById(10L).get(),null,"5"));
//             barTableR.save(new TableEntity(2,false,barR.findById(10L).get(),null,"6"));
//             barTableR.save(new TableEntity(1,false,barR.findById(10L).get(),null,"7"));
//             barTableR.save(new TableEntity(4,false,barR.findById(10L).get(),null,"8"));
//             barTableR.save(new TableEntity(4,false,barR.findById(10L).get(),null,"9"));
//             barTableR.save(new TableEntity(4,false,barR.findById(10L).get(),null,"10"));
//             barTableR.save(new TableEntity(4,false,barR.findById(10L).get(),null,"11"));
//             barTableR.save(new TableEntity(4,false,barR.findById(10L).get(),null,"12"));

//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(16L).get(), scheduleR.findById(1L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(17L).get(), scheduleR.findById(2L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(17L).get(), scheduleR.findById(3L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(18L).get(), scheduleR.findById(3L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(18L).get(), scheduleR.findById(4L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(19L).get(), scheduleR.findById(4L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(20L).get(), scheduleR.findById(3L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(20L).get(), scheduleR.findById(2L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(21L).get(), scheduleR.findById(1L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(21L).get(), scheduleR.findById(2L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(22L).get(), scheduleR.findById(3L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(22L).get(), scheduleR.findById(3L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(23L).get(), scheduleR.findById(3L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(23L).get(), scheduleR.findById(4L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(24L).get(), scheduleR.findById(1L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(25L).get(), scheduleR.findById(4L).get()));
//             scheduleTableReservationR.save(new ScheduleTableReservationEntity(barTableR.findById(26L).get(), scheduleR.findById(4L).get()));

//             offerR.save(new OfferEntity("Dos jarras por 3€", "De lunes a domingo dos jarras por 3€", "/images/offers/bar10/la-vina-de-martin-offer7.jpg", 2.3, 23, 23,  LocalDate.of(2021, 06, 01), LocalDate.of(2023, 01, 01), barR.findById(10L).get() ));
//             offerR.save(new OfferEntity("Tapa gratis", "Tapa gratis por usar gothere", "", 2.3, 23, 23, LocalDate.of(2021, 06, 01), LocalDate.of(2050, 01, 01),  barR.findById(10L).get() ));
//             offerR.save(new OfferEntity("4 copas por 15€", "De lunes a jueves las copas mas baratas", null, 8.00, 15, 0, LocalDate.of(2021,05,30), LocalDate.of(2022, 01, 01), barR.findById(10L).get() ));
//             offerR.save(new OfferEntity("Patatas gratis", "De lunes a viernes las copas mas baratas", null, 22.50, 15, 0, LocalDate.of(2021,05,30), LocalDate.of(2022, 01, 01), barR.findById(10L).get() ));
            

//             reservationBookR.save(new ReservationBookEntity( userR.findById(1L).get(),LocalDate.now(), false, scheduleTableReservationR.findById(9L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(2L).get(),LocalDate.now(), false, scheduleTableReservationR.findById(10L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(2L).get(),LocalDate.now(), true, scheduleTableReservationR.findById(11L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(2L).get(),LocalDate.now(), true, scheduleTableReservationR.findById(12L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(2L).get(),LocalDate.of(2021,05,1), false, scheduleTableReservationR.findById(13L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(1L).get(),LocalDate.of(2023,8,21), true, scheduleTableReservationR.findById(14L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(1L).get(),LocalDate.of(2023,8,24), false, scheduleTableReservationR.findById(15L).get()));
//             reservationBookR.save(new ReservationBookEntity( userR.findById(1L).get(),LocalDate.of(2021,05,23), false, scheduleTableReservationR.findById(16L).get()));
//             barImgsR.save(new BarImgsEntity( "/images/bars/logo1.png" , barR.findById(1L).get(), 1L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/logo2.jpg" , barR.findById(2L).get(), 2L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/logo3.jpg" , barR.findById(3L).get(), 3L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/logo4.jpg" , barR.findById(4L).get(), 4L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/logo5.jpg" , barR.findById(5L).get(), 5L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/logo6.jpg" , barR.findById(6L).get(), 6L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/logo6.jpg" , barR.findById(7L).get(), 7L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/bardefault.jpg" , barR.findById(1L).get(), 8L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/bardefault.jpg" , barR.findById(2L).get(), 9L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/bardefault.jpg" , barR.findById(3L).get(), 10L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/bardefault.jpg" , barR.findById(4L).get(), 11L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/bardefault.jpg" , barR.findById(5L).get(), 12L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/bardefault.jpg" , barR.findById(6L).get(), 13L));
//             barImgsR.save(new BarImgsEntity( "/images/bars/bardefault.jpg" , barR.findById(7L).get(), 14L));
//             userofferR.save(new UserOfferEntity(user1, offerR.findById(1L).get()));
//             userofferR.findById(1L).get().setCode("ABCD");
//         };
//     }
// }
