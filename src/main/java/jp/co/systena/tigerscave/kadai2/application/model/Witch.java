package jp.co.systena.tigerscave.kadai2.application.model;

public class Witch extends Work{
  private String attack;
  @Override
  public void fight() {
      attack=super.getName()+"はまほうで攻撃した！";

  }
  public String getAttack() {
      return attack;
  }
  public void setAttack(String attack) {
      this.attack = attack;
  }

}
