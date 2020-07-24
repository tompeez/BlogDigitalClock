package de.hahn.blog.digitalclock.view;

import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.output.RichOutputText;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;


public class DigitalClockBean {
    private int initClock = 0;
    private RichOutputText digitalClockOutput;
    private DigitalClockContextBean context;
    private String time;


    public DigitalClockBean() {
    }

    public void setContext(DigitalClockContextBean context) {
        this.context = context;
    }

    public DigitalClockContextBean getContext() {
        return context;
    }

    public void setInitClock(int initClock) {
        this.initClock = initClock;
    }

    public int getInitClock() {
        return initClock;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        String ret = null;
        if (digitalClockOutput != null) {
            String initTimer = getContext().getInitTime();
            if (initTimer == null) {
                String clientId = digitalClockOutput.getClientId();
                String script = "startTime('" + clientId + "')";
                injectJSToPage(script);
                getContext().setInitTime("true");
            }
            ret = this.time;
        }
        return ret;
    }

    public static void injectJSToPage(String script) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks = Service.getService(facesContext.getRenderKit(), ExtendedRenderKitService.class);
        erks.addScript(facesContext, script);
    }

    public void setDigitalClockOutput(RichOutputText digitalClockOutput) {
        this.digitalClockOutput = digitalClockOutput;
    }

    public RichOutputText getDigitalClockOutput() {
        return digitalClockOutput;
    }


}
