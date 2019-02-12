package dunbar.parker.csc280.hellospring;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class ServerInfoRestController {
	
	private static List<Long> lastCalledTimestamps = new ArrayList<>();

	@RequestMapping("")
	public @ResponseBody ServerInfo getInfo() {
		ServerInfo info = new ServerInfo();
		info.setServerTime(new Date().toString());
		lastCalledTimestamps.add(System.currentTimeMillis());
		info.setLastCalledTimes(lastCalledTimestamps);
		return info;
	}
}
