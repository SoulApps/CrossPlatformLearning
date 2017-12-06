public enum Color {
	 ROJO("FF0000"), VERDE("00FF00"),  AZUL("0000FF");
	 private String rgb;
	 Color(String rgb) {
		 this.rgb = rgb;
	 }
	 public String getRgb() {
		 return rgb;
	 }
}
