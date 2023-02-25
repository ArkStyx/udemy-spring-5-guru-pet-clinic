package udemy.spring5.guru.sfgpetclinic.formatters;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import udemy.spring5.guru.sfgpetclinic.models.PetType;
import udemy.spring5.guru.sfgpetclinic.services.PetTypeService;

/*
 * TODO CLASSE POUR CORRIGER L'ERREUR SUIVANTE DANS L'IHM : createOrUpdatePetForm.html
 * Caused by: org.springframework.core.convert.ConversionFailedException: 
 * Failed to convert from type [java.lang.String] to type [java.lang.Long] for value 'Cat'; 
 * nested exception is java.lang.NumberFormatException: For input string: "Cat"
 */
@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
    	
        Collection<PetType> findPetTypes = petTypeService.findAll();
        for (PetType type : findPetTypes) {
            if (type.getName().equals(text)) {
                return type;
            }
        }

        throw new ParseException("Type d'animal non trouve : " + text, 0);
    }
    
}
