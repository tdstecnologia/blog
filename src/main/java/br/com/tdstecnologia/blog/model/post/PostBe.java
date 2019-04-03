package br.com.tdstecnologia.blog.model.post;

public class PostBe {

    private PostDao postDao;

    public PostBe() {
        this.postDao = new PostDao();
    }

    public void salvarPost(PostVo postVo) {
        getPostDao().salvarPost(postVo);
    }

    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }

}
