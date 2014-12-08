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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sample.jetty.service.GreetingsService;

@Controller
public class SampleController {

	@Autowired
	private GreetingsService greetingsService;

	@RequestMapping("/hello")
	@ResponseBody
	public String helloWorld() {
		return this.greetingsService.getHelloMessage();
	}

	@RequestMapping("/protected") // url akcji
	public String protectedAction(Model model) {
		model.addAttribute("attr1", "value of attr1");
		model.addAttribute("attr2", "value of attr2");
		return "protected"; // zwracamy nazwe widoku w /templates
	}

}
