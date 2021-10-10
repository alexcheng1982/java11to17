package io.vividcode.java11to17.ffm;

import java.util.ArrayList;
import java.util.List;

public class PointStructureMain {

  public static void main(String[] args) {
    PointStructure pointStructure = new PointStructure();
    List<Point> points = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      points.add(new Point(i * 2, i * 3));
    }
    List<Point> result = pointStructure.load(pointStructure.save(points));
    System.out.println(result);
  }
}
