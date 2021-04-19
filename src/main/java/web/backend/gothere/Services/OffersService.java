package web.backend.gothere.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import web.backend.gothere.Repositories.Entities.OfferEntity;
import web.backend.gothere.Repositories.Interfaces.OffersRepository;
import web.backend.gothere.Services.Models.OfferDTO;

public class OffersService {
    @Autowired
    private OffersRepository offersRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<OfferDTO> getAll() throws ResponseStatusException {
        
        List<OfferDTO> offersList = offersRepository.findAll().stream()
        .map(x -> modelMapper.map(x, OfferDTO.class))
        .collect(Collectors.toList());

        if(!offersList.isEmpty()){
            return offersList;
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error finding data");
        }
    }

    public OfferDTO add(OfferDTO offer){
        try {
            OfferEntity entityToInsert = modelMapper.map(offer, OfferEntity.class);
            offersRepository.save(entityToInsert);
            return offer;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        
       
    }

    public Optional<OfferDTO> update(Long id, OfferDTO offer){
        Optional<OfferEntity> dataToUpdate = offersRepository.findById(id);
        if(dataToUpdate.isPresent()){
            if(dataToUpdate.get().getIdOffer() == id){
                OfferEntity entityToUpdate = modelMapper.map(offer, OfferEntity.class);
                entityToUpdate.setIdOffer(id);
                OfferEntity result = offersRepository.save(entityToUpdate);
                return Optional.of(modelMapper.map(result, OfferDTO.class));
            }
        }
        return Optional.empty();
    }

    public OfferDTO findbyOfferId(Long id) throws ResponseStatusException{
        Optional<OfferEntity> entity = offersRepository.findById(id);
        if(entity.isPresent()){
            return modelMapper.map(entity.get(), OfferDTO.class);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public List<OfferDTO> findOffersByBarId(Long id) throws ResponseStatusException{

        List<OfferDTO> offersList = offersRepository.findByBar(id).stream()
        .map(x -> modelMapper.map(x, OfferDTO.class))
        .collect(Collectors.toList());

        if(!offersList.isEmpty()){
            return offersList;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No data found");
        }
    }


    public void deleteById(Long id) throws ResponseStatusException{
        Optional<OfferEntity> entityToDelete = offersRepository.findById(id);
        if(entityToDelete.isPresent()){
            offersRepository.delete(entityToDelete.get());
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error deletting data");
        }
    }
}
