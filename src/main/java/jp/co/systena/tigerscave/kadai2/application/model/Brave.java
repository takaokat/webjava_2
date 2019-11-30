package jp.co.systena.tigerscave.kadai2.application.model;

public class Brave extends Work {
  private String attack;
  @Override
  public void fight() {
      // TODO 自動生成されたメソッド・スタブ
      attack= super.getName()+"は剣で攻撃した！";

  }

  public String getAttack() {
      return attack;
  }

  public void setAttack(String attack) {
      this.attack = attack;
  }


}
