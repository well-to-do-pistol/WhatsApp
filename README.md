WhatsApp:

零:

> 1\. 登录动画SplashActivity(创建线程延迟3秒启动登录页面)
>
> 2\. 加载动画用progressbar
>
> 3\. 用FirebaseAuth库(电话)注册登录, 设置测试电话和验证码(+91 99999 99911
> -\> 111111)(没有银行卡每天限10条)
>
> 4\. 使用firebase ui库, 设置FirestoreRecyclerAdapter\<UserModel,holder\>,
> 直接检索数据库拿到对象进行显示;
>
> 5\. 用include包括的子layout设置drawable中的圆shape来显示圆图

1.  LoginPhoneNumberActivity

```{=html}

```

1.  Background设置edittext背景, elevation设置阴影

2.  用hbb20:ccp库,
    用CountryCodePicker(可以直接检查有效)得到电话地区码和edittext绑定一起

```{=html}

```

2.  LoginOTPActivity

```{=html}

```

1.  从Intent拿到getExtras传过来的完整电话

2.  设置发验证码方法(标记是否重发), 编写回调函数(成功就显示成功)

3.  用timer.scheduleAtFixedRate计秒重发(描述到了设置按钮可按)

```{=html}

```

1.  LoginUsernameActivity

```{=html}

```

1.  用Cloud Firestore保存users

```{=html}

```

2.  MainActivity

```{=html}

```

1.  底部导航栏用GoogleMaterial的bottomnavigation中放menu

2.  分割线用MaterialDivider(), google-material库

3.  关

```{=html}

```

3.  SearchUserActivity

```{=html}

```

1.  用include在一个layout包含另一个layout

2.  直接用Query检索数据库, 塞进Options, 再塞进adapter,
    再塞进recyclerView, 再startListening

3.  点击item后, 将所有信息一条条通过intent的putExtra传递

4.  直接通过id检索storage拿到图片显示

```{=html}

```

4.  ChatActivity

```{=html}

```

1.  用Cloud Firestore保存(ChatroomModel)chatrooms,
    子文档名是roomId(计算user1和user2的Id哈希, 谁小谁排前面,
    用_组成roomId)

2.  在roomId中多设一个chats文档, 保存(ChatMessageModel)所有聊天,
    聊天id下记录信息,发送人,时间戳

3.  发送成功后setText("")清空聊天框; 用传来的userId组成roomId拿到room,
    往里面chats添加chat,
    根据发送者区分开来(根据model的发送者id和currentId对比,
    是则(反向)显示右边栏消息), (根据时间戳降序排列chats)

4.  recyclerView.smoothScrollToPosition(0)滑到开始

5.  直接通过id检索storage拿到图片显示

```{=html}

```

5.  ChatFragment

```{=html}

```

1.  先检索chatrooms, 查看id列表哪个与currentId相同, 取另一个id.
    最近对话先用ChatroomModel 的lastMessageTimestamp降序排列,
    使用lastMessageSenderId得到发送方是谁, 取lastMessage

2.  添加chatrooms:userIds Arrays lassMessageTimestamp Descending
    \_name\_ Descending复合索引(往Query加规则必须添加索引不然报错)

3.  直接通过id检索storage拿到图片显示

```{=html}

```

6.  ProfileFragment

> 1\. 用getSharedPrefer
>
> 2\. logout直接用FirebaseUtil.logout,
> 然后在Intent添加NEW和CLEAR的Flags, 启动SplashActivity
>
> 3\. 用dhaval2404:imagepicker修改头像(打开文件, 剪切设置大小的图片),
> 用Glide库(将图片放到View上)
>
> 4\. 用Storage保存profile_pic来保存头像,
> 直接通过id检索storage拿到自己的图片显示(6)
