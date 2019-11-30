package jp.co.systena.tigerscave.kadai2.application.model;

public abstract class Work {

  private String name;

   public String getName() {
      return name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public abstract void actionAttack();
  public abstract void actionHeal();

}