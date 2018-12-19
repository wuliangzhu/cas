package com.wuliangzhu.controller;

import com.wuliangzhu.common.ServiceResponse;
import com.wuliangzhu.service.CasClient;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.pac4j.core.client.BaseClient;
import org.pac4j.core.client.Clients;
import org.pac4j.core.context.J2EContext;
import org.pac4j.core.context.WebContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CasController {
    private Logger logger = LoggerFactory.getLogger(CasController.class);
    private CasClient casClient;

    @RequestMapping("/cas/login")
    public String login(HttpServletRequest request, HttpServletResponse response, Model model) {
        String query = request.getQueryString();
        String callback = request.getParameter("service");

        // TODO: 根据 client_name 进行真实的账号验证

        if (isAuthenticated()) {
            // 登录成功要重定向到app服务器的回调接口
            return "redirect:" + callback + "&token=12345678";
        }
        final WebContext context = new J2EContext(request, response);
        //定义cas客户端
        final CasClient casClient = this.casClient;

        model.addAttribute("casAuthUrl",  getClientLocation(casClient, context));
        return "login";
    }

    /**
     * cas 的 检验tickit 是否有效
     *
     * service ticket renew
     * @return
     */
    @RequestMapping("/cas/serviceValidate")
    @ResponseBody
    public String validate() {
        ServiceResponse.AuthenticationSuccess success = ServiceResponse.createSuccess();
        success.user = "lisan";
        success.attributes.put("id", "12334");

        return success.toString();
    }

    //获取客户端的链接
    public String getClientLocation(BaseClient client, WebContext context) {

//        try {
//            return ((CasClient)client).getRedirectAction(context).getLocation();
//        } catch (RequiresHttpAction e) {
//            e.printStackTrace();
//            logger.error("error", e);
//            return null;
//        }

        return ((CasClient)client).getRedirectAction(context).getLocation();
    }

//
    protected boolean isAuthenticated() {
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        return !(auth instanceof AnonymousAuthenticationToken);
        return true;
    }
}
