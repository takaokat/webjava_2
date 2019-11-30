package jp.co.systena.tigerscave.kadai2.application.model;

public class Warrior extends Work{
  private String action;

  @Override
  public void  setActionAttack() {
     action = super.getName() + "は拳で攻撃した！";
  }
  @Override
  public void setActionHeal() {
    action = super.getName() + "はやくそうで回復した！";
  }

  public String getAction() {
     return action;
  }

}
