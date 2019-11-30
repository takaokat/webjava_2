package jp.co.systena.tigerscave.kadai2.application.model;

public class Witch extends Work{
  private String action;

  public void  setActionAttack() {
    action = super.getName() + "はまほうで攻撃した！";
 }
 @Override
 public void setActionHeal() {
   action = super.getName() + "はまほうで回復した！";
 }

 public String getAction() {
    return action;
 }


}
