package io.vividcode.java11to17.textblock.old;

import io.vividcode.java11to17.textblock.User;

public class StringTemplate {

  public String generate(User user) {
    return "<user>\n"
        + "  <id>"
        + user.id()
        + "</id>\n"
        + "  <name>"
        + user.name()
        + "</name>\n"
        + "  <email>"
        + user.email()
        + "</email>\n"
        + "</user>";
  }
}
