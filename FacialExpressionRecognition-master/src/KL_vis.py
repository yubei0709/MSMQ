import numpy as np
import matplotlib.pyplot as plt

# 两个正态分布之间KL散度的函数
def kl_divergence_normal(mu1, sigma1, mu2, sigma2):
    ln_sigma1 = np.log(sigma1)
    ln_sigma2 = np.log(sigma2)
    element1 = ln_sigma2 - ln_sigma1
    element2 = (sigma1 ** 2 / sigma2 ** 2)
    element3 = (2 * np.pi) ** 2 / sigma2 ** 2
    kl_value = 0.5 * (element1 - element2 + element3 + ((mu1 - mu2) ** 2 / sigma2 ** 2))
    return kl_value

# 定义正态分布参数
mu1, sigma1 = 0, 1
mu2, sigma2 = 0.5, 1

# 计算KL散度
kl_value_manual = kl_divergence_normal(mu1, sigma1, mu2, sigma2)

# 打印结果
print(f"KL散度: {kl_value_manual}")

# 绘制KL散度随正态分布参数变化的图像
x = np.linspace(-5, 5, 200)
y_manual = kl_divergence_normal(x, sigma1, mu2, sigma2)

plt.figure(figsize=(10, 5))
plt.plot(x, y_manual)
plt.xlabel('mu1')
plt.ylabel('KL Divergence')
plt.title('KL Divergence between two Normal Distributions')
plt.legend()
plt.show()
