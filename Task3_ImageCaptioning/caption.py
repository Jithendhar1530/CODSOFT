from tensorflow.keras.applications.resnet50 import ResNet50, preprocess_input, decode_predictions
from tensorflow.keras.preprocessing import image
import numpy as np

# Load model
model = ResNet50(weights='imagenet')

def generate_caption(img_path):
    img = image.load_img(img_path, target_size=(224, 224))
    x = image.img_to_array(img)
    x = np.expand_dims(x, axis=0)
    x = preprocess_input(x)

    preds = model.predict(x)
    results = decode_predictions(preds, top=3)[0]

    print("Generated Caption:")
    for _, label, prob in results:
        print(f"{label} ({prob:.2f})")

# Run
generate_caption("Task3_ImageCaptioning.png")
