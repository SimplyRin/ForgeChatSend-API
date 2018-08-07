# ForgeChatSend-API
Forge でクライアントが送信したチャットメッセージをイベントで取得する物

# Event Usage
```Java
	@SubscribeEvent
	public void onChatSend(ChatSendEvent event) {
		# event.isCommand(); -> イベントがコマンドか(/から始まっている)か
		# event.getMessage(); -> 送信したメッセージを取得
    
		System.out.println("onChatSend: " + event.getMessage());
	}
```
