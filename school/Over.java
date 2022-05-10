package school;

// 미완성 메서드가 하나라도 있으면 미완성 클래스
abstract class Player {
  abstract void shoot();
}

class Center extends Player {
  @Override
  void shoot() {
    System.out.println("Center Shoot");
  }
}

class Guard extends Player {
  @Override
  void shoot() {
    System.out.println("Guard Shoot");
  }
}

class Forward extends Player {
  @Override
  void shoot() {
    System.out.println("Forward Shoot");
  }
}

public class Over {
  public static void main(String[] args) {
    Player playerList[] = new Player[5];

    playerList[0] = new Center();
    playerList[1] = new Guard();
    playerList[2] = new Forward();

    playerList[0].shoot();
    playerList[1].shoot();
    playerList[2].shoot();
  }
}