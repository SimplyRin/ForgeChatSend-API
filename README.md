# ForgeChatSend-API
Forge でクライアントが送信したチャットメッセージをイベントで取得する物

# Event Usage
[ForgeChatSend-API.1.1.jar](https://github.com/SimplyRin/ForgeChatSend-API/releases/download/1.1/ForgeChatSend-API-1.1.jar) を [Release](https://github.com/SimplyRin/ForgeChatSend-API/releases) よりダウンロードして Gradle などでインポートしてください。

`mods` フォルダにもこのファイルを入れる必要があります。
```Java
	@SubscribeEvent
	public void onChatSend(ChatSendEvent event) {
		// event.isCommand(); -> イベントがコマンドか(/から始まっている)か
		// event.getMessage(); -> 送信したメッセージを取得
    
		System.out.println("onChatSend: " + event.getMessage());
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
