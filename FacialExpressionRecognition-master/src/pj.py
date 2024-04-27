import matplotlib.pyplot as plt
import matplotlib.image as mpimg

# 加载第一张图片
image_path_1 = '../output/1.png'
img1 = mpimg.imread(image_path_1)

# 加载第二张图片
image_path_2 = '../output/2.png'
img2 = mpimg.imread(image_path_2)

# 创建一个新的figure对象
fig, axs = plt.subplots(1, 2, figsize=(10, 5))

# 在子图1中显示第一张图片
axs[0].imshow(img1)
axs[0].axis('off')  # 关闭坐标轴

# 在子图2中显示第二张图片
axs[1].imshow(img2)
axs[1].axis('off')  # 关闭坐标轴

# 显示图像
plt.tight_layout()  # 自动调整子图参数，使之填充整个图像区域
plt.show()
