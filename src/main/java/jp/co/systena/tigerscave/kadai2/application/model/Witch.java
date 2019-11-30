package jp.co.systena.tigerscave.kadai2.application.model;

public class Witch extends Work{
  private String attack;
  private String heal;

  @Override
  public void  actionAttack() {
     attack = super.getName() + "はまほうで攻撃した！";
  }
  @Override
  public void actionHeal() {
    heal = super.getName() + "はまほうで回復した！";
  }

  public String getAttack() {
     return attack;
  }
  public void setAttack(String attack) {
    this.attack = attack;
  }

  public String getHeal() {
    return heal;
  }
  public void setHeal(String heal) {
    this.heal = heal;
  }

}
