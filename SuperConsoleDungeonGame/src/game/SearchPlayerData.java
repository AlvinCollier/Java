package game;

public class SearchPlayerData {

	public String[] findPlayerDataInSaveFile(String[] data, String key) {
		
		String[] playerData = new String[9];
		for (int i = 0; i < data.length; i++){    
            if (data[i].contains(key)){
            	playerData = getPlayerFromSavedData(data[i]);
            }
        }
		return(playerData);
		
	}
	
	public String[] getPlayerFromSavedData(String player) {
		
		String[] playerData = player.split("#");
		return(playerData);
	}
	
}
