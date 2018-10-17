package router.response;

import router.Router;

public class RedirectResponse implements Response {

    private String url;

    public RedirectResponse(String url) {
        this.url = url;
    }

    @Override
    public void execute(Router router) {
        router.navigate(url);
    }

}
