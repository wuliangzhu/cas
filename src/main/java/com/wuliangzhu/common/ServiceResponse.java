package com.wuliangzhu.common;

import java.util.HashMap;
import java.util.Map;

/**
 *  <cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>
 *     <cas:authenticationSuccess>
 *         <cas:user>jason,102</cas:user>
 *         <cas:attributes>
 *             <cas:sn>lei</cas:sn>
 *             <cas:email>jason@abc.net</cas:email>
 *             <cas:loginid>jason</cas:loginid>
 *         </cas:attributes>
 *     </cas:authenticationSuccess>
 * </cas:serviceResponse>
 */
public class ServiceResponse {

    /**
     * <cas:serviceResponse>
     *  <cas:authenticationSuccess>
     *     <cas:user>ligang</cas:user>
     *     <cas:attributes>
     *         <cas:id></cas:id>
     *     </cas:attributes>
     *  </cas:authenticationSuccess>
     * </cas:serviceResponse>
     */

    public static AuthenticationSuccess createSuccess() {
        return new AuthenticationSuccess();
    }

    public static AuthenticationFailure createFailure() {
        return new AuthenticationFailure();
    }

    public static class AuthenticationSuccess{
        public String user;
        public Map<String, String> attributes = new HashMap<>();

        public String toString() {
            StringBuffer sb = new StringBuffer();

            sb.append("<cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>");
            sb.append("<cas:authenticationSuccess>");

            sb.append("<cas:user>");
            sb.append(this.user);
            sb.append("</cas:user>");

            sb.append("<cas:attributes>");
            this.attributes.forEach( (k, v) -> {
                sb.append("<cas:" + k + ">");
                sb.append(v);
                sb.append("</cas:" + k + ">");
            });
            sb.append("</cas:attributes>");

            sb.append("</cas:authenticationSuccess>");
            sb.append("</cas:serviceResponse>");

            return sb.toString();
        }
    }

    /**
     * INVALID_REQUEST - not all of the required request parameters were present
     * INVALID_TICKET - the ticket provided was not valid, or the ticket did not come from an initial login and "renew" was set on validation. The body of the <cas:authenticationFailure> block of the XML response SHOULD describe the exact details.
     * INVALID_SERVICE - the ticket provided was valid, but the service specified did not match the service associated with the ticket. CAS MUST invalidate the ticket and disallow future validation of that same ticket.
     * INTERNAL_ERROR - an internal error occurred during ticket validation
     *
     * <cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>
     *     <cas:authenticationFailure code="INVALID_TICKET">
     *         Ticket ST-1856339-aA5Yuvrxzpv8Tau1cYQ7 not recognized
     *     </cas:authenticationFailure>
     *  </cas:serviceResponse>

     */
    public static class AuthenticationFailure{
        public String code;
        public String text;

        public String toString() {
            StringBuffer sb = new StringBuffer();

            sb.append("<cas:serviceResponse xmlns:cas='http://www.yale.edu/tp/cas'>");
            sb.append("<cas:authenticationFailure code=\"" + this.code + "\" >");

            sb.append(this.text);

            sb.append("</cas:authenticationFailure>");
            sb.append("</cas:serviceResponse>");

            return sb.toString();
        }
    }
}
