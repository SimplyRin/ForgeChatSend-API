# ForgeChatSend-API
Forge でクライアントが送信したチャットメッセージをイベントで取得する物

# Usage
[ForgeChatSend-API.1.2.jar](https://github.com/SimplyRin/ForgeChatSend-API/releases/download/1.2/ForgeChatSend-API-1.2.jar) を [Release](https://github.com/SimplyRin/ForgeChatSend-API/releases) よりダウンロードして Gradle などでインポートしてください。

`mods` フォルダにもこのファイルを入れる必要があります。
```Java
	import net.simplyrin.chatsendapi.event.ChatSendEvent;
	
	@SubscribeEvent
	public void onChatSend(ChatSendEvent event) {
		// event.isCommand(); -> メッセージがコマンドか(/から始まっている)かどうか
		
		// event.setMessage(String); -> 送信するメッセージを再指定
		// event.getMessage(); -> 送信するメッセージを取得
		
		// event.setCanceled(boolean); -> 受け取ったイベントをキャンセルする
		// event.isCanceled(); -> イベントがキャンセルされたかどうか

		// 1.2 からクライアントコマンドを作ることができます。

		String[] args = event.getMessage().split(" ");
		
		if(args.length > 0) {
			if(args[0].equalsIgnoreCase("/hello")) {
				event.setCanceled(true);
				this.sendMessage("Hello!");
			}
		}
	}
```

# Open Source License
**・jOOR | Apache License 2.0**
```
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
