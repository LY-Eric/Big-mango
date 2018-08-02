var app = getApp();

Page({

  /**
   * 页面的初始数据
   */
  data: {
    src: "",
    token: "",
    pictures: [
      'http://39.105.132.87:8081/images/2018-06-17/a.jpeg',
      'http://39.105.132.87:8081/images/2018-06-17/b.jpeg',
      'http://39.105.132.87:8081/images/2018-06-17/c.jpeg',
      'http://39.105.132.87:8081/images/2018-06-17/d.jpeg',
      'http://39.105.132.87:8081/images/2018-06-17/e.jpeg'
    ]
  },
  previewImage: function (e) {
    var that = this,
      index = e.currentTarget.dataset.index,
      pictures = this.data.pictures;
    wx.previewImage({
      current: pictures[index],
      urls: pictures
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    
  },
  chooseImg: function(res) {
    var that = this;
    wx.chooseImage({
      count: 1, // 默认9
      sizeType: ['compressed'], // 可以指定是原图还是压缩图，默认二者都有
      sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
      success: function (res) {
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths;
        try {
          var value = wx.getStorageSync('token')
          if (value) {
            that.setData({
              token: value
            })
            upload(that, tempFilePaths);
            
          }
        } catch (e) {
          // Do something when catch error
        }
        
      }
    })
  }
})

function upload(page, path) {
    wx.showToast({
      icon: "loading",
      title: "正在上传"
    }),
    wx.uploadFile({
      url: app.globalData.baseUrl + "/file/upload",
      filePath: path[0],
      name: 'file',
      header: { "Content-Type": "multipart/form-data" },
      formData:{
        'token': page.data.token
      },
      success: function (res) {
        console.log("res", res)
        console.log("服务器返回：", res.data.data);
        if (res.statusCode != 200) {
          wx.showModal({
            title: '提示',
            content: '上传失败',
            showCancel: false
          })
        } else {
          //console.log("setdata前：", page.data.pictures)
          //page.setData({
          //  pictures: res.data
          //})
          //console.log("setdata后：", page.data.pictures)
        }
      },
      fail: function (e) {
        console.log(e)
        wx.showModal({
          title: '提示',
          content: '上传失败',
          showCancel: false
        })
      },
      complete: function () {
        wx.hideToast();  //隐藏Toast
      }
    })
}