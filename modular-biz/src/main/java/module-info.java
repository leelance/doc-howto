module modular.lance.biz {
  // spring dependency
  requires spring.web;
  requires spring.boot;
  requires spring.context;
  requires spring.boot.autoconfigure;

  // common dependency
  requires lombok;
  requires org.slf4j;
  requires com.google.common;
  requires java.net.http;

  //custom dependency
  requires modular.lance.common;
}
