package com.ylab.homework.hw4.movie;

import java.io.File;
import javax.sql.DataSource;

public class MovieLoaderImpl implements MovieLoader {
  private DataSource dataSource;

  public MovieLoaderImpl(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public void loadData(File file) {
    // РЕАЛИЗАЦИЮ ПИШЕМ ТУТ
  }
}
