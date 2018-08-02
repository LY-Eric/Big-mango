var app = getApp();
Page({
  data:{
    userInfo:{},
    identity:"",
    signFlag: true
  },
  sign: function(e) {
    var that = this
    wx.getStorage({
      key: 'token',
      success: function (res) {
        console.log(res.data)
        wx.request({
          url: app.globalData.baseUrl + '/sign/doSign',
          data: {
            token: res.data
          },
          header: {
            'content-type': 'application/x-www-form-urlencoded '
          },
          method: 'POST',
          success: function (callback) {
            console.log(callback)
            if (callback.data.status==200){
              that.setData({
                signFlag: false
              })
            }
          }
        })
      }
    })
    
  },
  onLoad:function(){
    var that = this;
    // 登录
    wx.login({
      success: res => {
        // 发送 res.code 到后台换取 openId, sessionKey, unionId
        let JSCODE = res.code 
        wx.request({
          url: app.globalData.baseUrl + '/wx/checkCode',
          data: {
            code: JSCODE
          },
          success: function(callback) {
            let res = callback.data;
            console.log(res);
            try {
              wx.setStorageSync('token', res.token)
            } catch (e) {
              console.log("setStorageSync throw exception")
            }
            that.setData({
              identity: res.identity
            })
          }
        })
      }
    })
    // 获取用户信息
    wx.getSetting({
      success: function(res){
        //console.log(res);
        if (res.authSetting['scope.userInfo']){
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称
          wx.getUserInfo({
            success: function (res) {
             that.setData({
               userInfo: res.userInfo
             })
             //调用接口
            }
          })
        }
      }
    })
  }
})