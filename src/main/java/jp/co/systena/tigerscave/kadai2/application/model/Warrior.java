package jp.co.systena.tigerscave.kadai2.application.model;

public class Warrior extends Work{
  private String attack;
  @Override
  public void fight() {
      attack=super.getName()+"は拳で攻撃した！";

  }
  public String getAttack() {
      return attack;
  }
  public void setAttack(String attack) {
      this.attack = attack;
  }

}