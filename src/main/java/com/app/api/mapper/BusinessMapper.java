package com.app.api.mapper;

import com.app.api.entity.BusinessKind;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BusinessMapper {

    private int businessId;
    private String name;

    public BusinessMapper(BusinessKind businessKind) {
        this(businessKind.getBusinessId(),businessKind.getName());
    }
}
