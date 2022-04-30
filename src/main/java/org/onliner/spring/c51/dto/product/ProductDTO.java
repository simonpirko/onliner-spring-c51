package org.onliner.spring.c51.dto.product;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
public class ProductDTO {
    private List<Long> propertiesList;

    public StringBuffer showList(){
        StringBuffer s = new StringBuffer();
        for (Long i : propertiesList){
            s=s.append(i);
            s=s.append("; ");
        }
        return s;
    }

}
