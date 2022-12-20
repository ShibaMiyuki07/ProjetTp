import {  IonContent, IonHeader, IonImg, IonItem, IonList, IonPage, IonTitle, IonToolbar } from "@ionic/react";
import {Camera, CameraOptions} from "@ionic-native/camera";
const addPhoto = async (image : any) =>
{
  const libraryImage = await openLibrary();
  image = libraryImage;
  console.log(image);
}

const openLibrary = async () =>
{
  const options : CameraOptions = {
    quality : 100,
    destinationType : Camera.DestinationType.DATA_URL,
    encodingType : Camera.EncodingType.JPEG | Camera.EncodingType.PNG,
    mediaType : Camera.MediaType.PICTURE,
    targetWidth : 1000,
    targetHeight : 1000,
    sourceType : Camera.PictureSourceType.SAVEDPHOTOALBUM
  };
  return await Camera.getPicture(options);
}

const Details : React.FC = () =>{
    const image = "assets/icon/icon.png";
    return(
        <IonPage>
            <IonHeader>
                <IonToolbar>
                <IonTitle>Login</IonTitle>
                 
                </IonToolbar>
            </IonHeader>
            <IonContent fullscreen>
                <IonHeader collapse="condense">
                <IonToolbar>
                    <IonTitle size="large">Login</IonTitle>
                                        
                </IonToolbar>
                </IonHeader>
                <IonList>
                    <IonItem>
                        <IonImg onClick={() => addPhoto(image)} src={image} alt="image de l'avion">
                            
                        </IonImg>
                    </IonItem>
                    <IonItem>
                        <IonList>
                            <IonItem>Nom : </IonItem>
                            <IonItem>Km effectuer : </IonItem>
                            <IonItem>Date d'entretien : 
                                <IonList>
                                    <IonItem>Vidange :</IonItem>
                                    <IonItem>Pneu : </IonItem>
                                </IonList>
                            </IonItem>
                            <IonItem>Date d'assurance : </IonItem>
                        </IonList>
                    </IonItem>
                </IonList>
            </IonContent>
        </IonPage>
    );
}

export default Details;