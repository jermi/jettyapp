/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package sample.jetty.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.jetty.domain.utils.PageableImpl;
import sample.jetty.service.GreetingsService;
import sample.jetty.service.StanProcesowSearchCriteria;
import sample.jetty.service.StanProcesowService;

import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Controller
public class SampleController {

	@Autowired
	private GreetingsService greetingsService;

    @Autowired
    private StanProcesowService stanProcesowService;

	@RequestMapping("/hello")
	@ResponseBody
	public String helloWorld() {
		return this.greetingsService.getHelloMessage();
	}

    @RequestMapping("/jpa")
    @ResponseBody()
    @Transactional(readOnly = true)
    public String jpaStanProcesow(@RequestParam(value = "procesId", required = false) String procesId) {
        StanProcesowSearchCriteria criteria = new StanProcesowSearchCriteria();
        if (!StringUtils.isEmpty(procesId)){
            criteria.setId(procesId);
        }
        return this.stanProcesowService.findStanProcesow(criteria, new PageableImpl()).toString();
    }

    //TODO nie działa, nie wiem czemu
    @RequestMapping("/model")
    public String home(Map<String, Object> model) {
        model.put("message", "Hello World");
        model.put("title", "Hello Home");
        model.put("date", new Date());
        return "model";
    }

    @RequestMapping("/exception")
    public String foo() {
        throw new RuntimeException("Expected exception in controller");
    }

}
