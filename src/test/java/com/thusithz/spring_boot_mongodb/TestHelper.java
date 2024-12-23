package com.thusithz.spring_boot_mongodb;


import com.thusithz.spring_boot_mongodb.dtos.PersonDTO;
import com.thusithz.spring_boot_mongodb.models.AddressEntity;
import com.thusithz.spring_boot_mongodb.models.CarEntity;
import com.thusithz.spring_boot_mongodb.models.PersonEntity;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class TestHelper {

    PersonEntity getMaxEntity() {
        PersonEntity maxEntity = new PersonEntity();
        maxEntity.setFirstName("Maxime");
        maxEntity.setLastName("Beugnet");

        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setCity("Paris");
        addressEntity.setCountry("France");
        addressEntity.setNumber(1);
        addressEntity.setPostcode("12345");
        addressEntity.setStreet("The Best Street");

        maxEntity.setAddressEntity(addressEntity);

        maxEntity.setAge(31);
        maxEntity.setInsurance(true);

        CarEntity carEntity = new CarEntity();
        carEntity.setBrand("Ferrari");
        carEntity.setMaxSpeedKmH(339f);
        carEntity.setModel("SF90 Stradale");

        maxEntity.setCarEntities(List.of(carEntity));

        return maxEntity;
    }

    PersonEntity getAlexEntity() {
        PersonEntity alexEntity = new PersonEntity();
        alexEntity.setFirstName("Alex");
        alexEntity.setLastName("Beugnet");
        AddressEntity addressEntity = new AddressEntity();

        addressEntity.setCity("Toulouse");
        addressEntity.setCountry("France");
        addressEntity.setNumber(2);
        addressEntity.setPostcode("54321");
        addressEntity.setStreet("Another Street");

        alexEntity.setAddressEntity(addressEntity);
        alexEntity.setAge(27);
        alexEntity.setInsurance(false);

        CarEntity carEntity = new CarEntity();

        carEntity.setBrand("Mercedes");
        carEntity.setMaxSpeedKmH(355f);
        carEntity.setModel("Project One");

        alexEntity.setCarEntities(List.of(carEntity));

         return  alexEntity;
    }

    PersonDTO getMaxDTO() {
        return new PersonDTO(getMaxEntity());
    }

    public PersonDTO getMaxDTOWithId(ObjectId id) {
        PersonEntity personEntity = getMaxEntity();
        personEntity.setId(id);

        return new PersonDTO(personEntity);
    }

    PersonDTO getAlexDTO() {
        return new PersonDTO(getAlexEntity());
    }

    PersonDTO getAlexDTOWithId(ObjectId id) {
        PersonEntity alexEntity = getAlexEntity();
        alexEntity.setId(id);
        return new PersonDTO(alexEntity);
    }

    List<PersonEntity> getListMaxAlexEntity() {
        return List.of(getMaxEntity(), getAlexEntity());
    }

    List<PersonDTO> getListMaxAlexDTO() {
        return List.of(getMaxDTO(), getAlexDTO());
    }
}
