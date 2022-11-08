package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeep.entity.Jeep;
import com.promineotech.jeep.entity.JeepModel;
import com.promineotech.jeep.service.JeepSalesService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j // This is a logging bridge that enables us to substitute any logger we want
public class DefaultJeepSalesController implements JeepSalesController {

	@Autowired
	private JeepSalesService jeepSalesService;

	@Override
	public List<Jeep> fetchJeeps(JeepModel model, String trim) {
		log.debug("model={}, trim={}", model, trim);
		return jeepSalesService.fetchJeeps(model, trim); // W14 Coding assignment ITEM#7 instructs us to keep this null instead of jeepSalesService.fetchJeeps(model, trim);
		
	}
}
