package br.com.alura.desafios;

import java.util.Date;
import java.util.List;

public record Livro(String title,
                    String subtitle,
                    List<String> authors,
                    String publisher,
                    Date publishedDate,
                    String description,
                    Integer pageCount,
                    List<String> categories) {
}
