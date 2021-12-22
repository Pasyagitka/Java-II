package meow.pasyagitka.findtrainingvideos.controller.advice;

public class Response {
    private String errors;

    public Response() {
    }

    public Response(String errors) {
        this.errors = errors;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

}
