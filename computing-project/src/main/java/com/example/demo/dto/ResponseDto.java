package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.example.demo.model.ComputingProjectModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@JsonInclude(value= Include.NON_NULL)
@Getter
@Setter
public class ResponseDto {
	
private List<ComputingProjectModel> ComputingProjectModelList;

}
