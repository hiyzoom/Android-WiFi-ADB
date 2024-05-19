package com.ewapp.wifi_adb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.ewapp.wifi_adb.ui.theme.WiFiADBTheme

// 应用的主页面
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WiFiADBTheme {
                // 使用Scaffold构建应用结构
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // 渲染Greeting函数
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

// 问候组件
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // 创建一个状态变量来存储TextField的值
    var text by remember { mutableStateOf("") }

    // 创建一个状态变量来管理Switch的状态
    var switchState by remember { mutableStateOf(false) }

    // 使用Column布局组织Text、TextField、Button、Switch
    Column(modifier = modifier.padding(16.dp)) {
        // 显示问候消息
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // 创建可以输入文本的TextField
        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text("Enter something...") },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        // 创建一个按钮
        Button(
            onClick = {
                // 当按钮被点击时, 执行的动作
                // 这里可以替换为任意你想要执行的代码
            },
            modifier = Modifier.padding(vertical = 8.dp) // 为按钮添加一些上下边距
        ) {
            // 按钮内部的文字
            Text("Click Me")
        }
        // 创建一个Switch组件
        Switch(
            checked = switchState,
            onCheckedChange = { switchState = it },
            // Switch的modifier参数，可用于调整尺寸、边距等
            modifier = Modifier.padding(vertical = 8.dp) // 为Switch添加一些上下边距
        )
    }
}

// 在预览中显示Greeting组件
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    WiFiADBTheme {
        Greeting("Android")
    }
}