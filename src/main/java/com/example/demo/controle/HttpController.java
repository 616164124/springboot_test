package com.example.demo.controle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HttpController {

  @RequestMapping("/https")
  @ResponseBody
  public void HttpTest(HttpServletRequest request) {
    System.out.println(request + "-----------------------");
    String ip = null;
    ip = request.getHeader("x-forwarded-for");

    request.getHeader("User-Agent");
    /*
    UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
     Browser browser = userAgent.getBrowser();
     OperatingSystem operatingSystem = userAgent.getOperatingSystem();
     Version browserVersion = userAgent.getBrowserVersion();
     System.out.println("------" + browser + "\n" + browserVersion + "\n" + operatingSystem);*/
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }
    if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
      ip = request.getRemoteAddr();
      if (ip.equals("127.0.0.1")) {
        InetAddress inet = null;
        try {
          inet = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
          e.printStackTrace();
        }
        ip = inet.getHostAddress();
      }
    }
    if ((ip != null) && (ip.length() > 15)) {
      if (ip.indexOf(",") > 0) {
        ip = ip.substring(0, ip.indexOf(","));
      }

      System.out.println(ip + "----------------------------");
    }
  }
}
