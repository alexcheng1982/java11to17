package io.vividcode.java11to17.textblock;

public class FormatStrings {

  public String format(User user) {
    return """
        <user>
          <id>%s</id>
          <name>%s</name>
          <email>%s</email>
        </user>
        """.formatted(user.id(), user.name(), user.email());
  }
}
