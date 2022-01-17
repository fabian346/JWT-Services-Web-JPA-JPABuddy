package com.kardex.api.model.dto.kardex;

import lombok.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
@Builder
@ToString
public class ProductoDto implements Serializable {

    private Long id;

    private String nombre;

    private String cantidad;
}
