/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mq1;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author sihai
 */
@Component
public class Recv {

    private static final Logger LOG = Logger.getLogger(Recv.class.getName());

    //@JmsListener(destination = "queue1",)
    public void onMessage(String msg) {
        LOG.log(Level.INFO, "msg : {0}", msg);
    }
}
