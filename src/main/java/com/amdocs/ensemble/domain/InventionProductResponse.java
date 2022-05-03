package com.amdocs.ensemble.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventionProductResponse<T>
{
    int recordCount;
    @JsonProperty("projectRecords")
    T response;
}
