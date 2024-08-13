//@flow
import domtoimage from 'dom-to-image-more';

async function captureRef(view, options) {
  if (options.result === "tmpfile") {
    console.warn("Tmpfile is not implemented for web. Try base64 or file.\n"+
                 "For compatibility, it currently returns the same result as data-uri");
  }
  const dataUrl = await domtoimage.toSvg(view);
  if (options.result === "data-uri" || options.result === "tmpfile") {
    return dataUrl;
  }
  return dataUrl.replace(/data:image\/(\w+);base64,/, '');
}

function captureScreen(options) {
  return captureRef(window.document.body, options);
}

function releaseCapture(uri) {
  throw new Error("Tmpfile is not implemented for web. Try base64 or file");
}

export default {
  captureRef,
  captureScreen,
  releaseCapture
}