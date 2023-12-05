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

  //custom dependency
  requires modular.lance.common;

  opens com.lance.doc.biz to spring.web, spring.boot, spring.context, spring.boot.autoconfigure;
}
