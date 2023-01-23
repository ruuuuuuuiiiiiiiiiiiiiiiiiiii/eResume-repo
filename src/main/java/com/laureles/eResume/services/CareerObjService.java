package com.laureles.eResume.services;

import java.util.List;

import com.laureles.eResume.entity.CareerObj;

public interface CareerObjService {
	
	List<CareerObj> getAllCareerObj();
	
	CareerObj getCareerObjById(Long id);
	
	CareerObj updateCareerObj(CareerObj CareerObj);
	
	void deleteCareerObjById(Long id);

	CareerObj saveCareerObj(CareerObj careerObj);
	

}
