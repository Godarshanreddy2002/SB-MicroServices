

import org.springframework.web.bind.annotation.GetMapping;

public interface BirthdayFeignClient {
	
	
	@GetMapping("/congrats")
	public String getBirthdayWishes();

}
