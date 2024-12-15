package com.example.app2;

import java.util.List;

public class NoticiaResponse {
    private String status;
    private int totalResults;
    private List<Noticia> articles;

    public List<Noticia> getListado_noticias() {
        return articles;
    }

  public int getTotalResults()
  {
      return totalResults;
  }
}